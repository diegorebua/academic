#include <Ultrasonic.h>
#include <BuzzerMelody.h>

#define pino_trigger 4
#define pino_echo 5

Ultrasonic ultrasonic(pino_trigger, pino_echo);
const byte led_1 = 13;
unsigned long cont=0;
unsigned long aux=0;
int buzzer1 = 8;
int pessoas=0;
long t1=0, t2=0;
BuzzerMelody melody(buzzer1);

void setup() {
  Serial.begin(9600);
  Serial.println("Lendo dados do sensor...");
  pinMode(led_1, OUTPUT);
  pinMode(buzzer, OUTPUT);
  digitalWrite(led_1, LOW);
  aux=millis();
}

void loop() {
  long microsec = ultrasonic.timing(); // ultrasonic.timing(); na IDE
  cont = millis();


  float distanciaCm = (microsec * 0.0343 / 2);

  if(distanciaCm <=20){//distanciaCm na IDE e distancia minima 0
    pessoas++;
  if(cont>=0){ 
  Serial.print("O total de leituras é: ");
  Serial.println(pessoas);
  pisca(led_1);
  buzzer(buzzer1);
  }
  else if(cont >= 1000){
    cont = cont - aux;
  }
  }
  else if(distanciaCm == 50){
    melody.playMelody();
    
    // Aguarda um pouco antes de repetir
    delay(2000);  // 2 segundos de pausa entre as repetições
  }

}
void buzzer(byte buzzer){
  for (int i=0; i <= 1; i++) {
    if(atraso(500, t1)){
    tone(buzzer1, 1500);
    noTone(buzzer1);
    }
  }
}
void pisca(byte led){
  if(atraso(500, t2)){
  digitalWrite(led_1, HIGH);
  digitalWrite(led_1, LOW);
  }
}
bool atraso(long time, long t){
  if(millis()>time){
    return true;
  }
  else{
    return false;
  }
}