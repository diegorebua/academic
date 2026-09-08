#include <Ultrasonic.h>

#define pino_trigger 4
#define pino_echo 5

Ultrasonic ultrasonic(pino_trigger, pino_echo);
const byte led_1 = 13;
unsigned long cont = 0;
unsigned long aux = 0;
int buzzer1 = 8;
int pessoas = 0;
long t1 = 0, t2 = 0;
boolean detecPessoa = false;
boolean musicPlayed = false; 

void setup() {
  Serial.begin(9600);
  Serial.println("Lendo dados do sensor...");
  pinMode(led_1, OUTPUT);
  pinMode(buzzer1, OUTPUT);
  digitalWrite(led_1, LOW);
  aux = millis();
}

void loop() {
  long microsec = ultrasonic.timing();
  cont = millis();

  float distanciaCm = (microsec * 0.0343 / 2);

  if (distanciaCm > 0 && distanciaCm <= 20 && !detecPessoa) {
    pessoas++;
    detecPessoa = true;
    if (cont >= 0) { 
      Serial.print("O total de leituras é: ");
      Serial.println(pessoas);
      pisca(led_1);
      buzzer(buzzer1);
    } else if (cont >= 1000) {
      cont = cont - aux;
    } 
  } else if (distanciaCm >= 21) {
    detecPessoa = false;
  }

  if (pessoas == 10 && !musicPlayed || pessoas == 50 && !musicPlayed) { 
    Serial.print("Parabens por ser a pessoa numero: ");
    Serial.println(pessoas);
    playHalloweenMelody();
    musicPlayed = true;
  }
}

void buzzer(byte buzzer) {
  tone(buzzer1, 3000);
  delay(200);
  noTone(buzzer1);
}

void pisca(byte led) {
  digitalWrite(led_1, HIGH);
  delay(500);
  digitalWrite(led_1, LOW);
}

void playHalloweenMelody() {
  int melody[] = {
    3000, 2766, 2616, 2766, 3000,
    3000, 2766, 2616, 2766, 3000,
    2616, 2469, 2616,
    2766, 3000, 2616,
    2766, 3000, 2766,
    3000
  };

  int noteDurations[] = {
    8, 8, 8, 8, 8,
    8, 8, 8, 8, 8,
    16, 16, 16,
    8, 8, 8,
    8, 8, 8,
    4
  };

  for (int thisNote = 0; thisNote < sizeof(melody) / sizeof(melody[0]); thisNote++) {
    int noteDuration = 1000 / noteDurations[thisNote];
    tone(buzzer1, melody[thisNote], noteDuration);
    delay(noteDuration * 1.3);
    noTone(buzzer1);
  }
}