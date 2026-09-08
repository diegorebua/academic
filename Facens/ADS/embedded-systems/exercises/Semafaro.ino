#include <Ultrasonic.h>

#define pino_trigger 4
#define pino_echo 5

Ultrasonic ultrasonic(pino_trigger, pino_echo);
const byte led_1 = 13;
unsigned long cont=0;
unsigned long aux=0;
int buzzer1 = 8;
int pessoas=0;

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


  float distanciaMm = (microsec * 0.0343 / 2);

  if(distanciaMm>0 && distanciaMm <=20){//distanciaMm na IDE e distancia minima 0
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

}
void buzzer(byte buzzer){
  for (int i=0; i <= 1; i++) {
    tone(buzzer1, 1000);
    delay(500);
    noTone(buzzer1);
  }
}
void pisca(byte led){
  digitalWrite(led_1, HIGH);
  delay(500);
  digitalWrite(led_1, LOW);
}
/*bool atraso(long time, long t){
  if(millis()>time){
    return.true;
  }
  else{
    return.false;
  }
}*/