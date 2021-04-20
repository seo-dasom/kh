// 전역 변수 및 함수 선언
int LED = 9;
int RLED = 3;
int GLED = 5;
int BLED = 6;

void setup() {
  // put your setup code here, to run once:
  // 초기화 코드 작성
  Serial.begin(9600);
  pinMode(RLED, OUTPUT);
  pinMode(GLED, OUTPUT);
  pinMode(BLED, OUTPUT);
  // digitalWrite(9, HIGH); // HIGH는 5v LOW는 0v
}

void loop() {
  // put your main code here, to run repeatedly:
  // 보드에서 동작할 코드 작성
  // delay(1000);
  // Serial.println("Hello Arduino");
  // digitalWrite(LED, HIGH);
  // delay(1000);
  // digitalWrite(LED, LOW);
  // delay(1000);

  // analogLED();

   analogRGB(RLED);
   analogRGB(GLED);
   analogRGB(BLED);
   analogOFF();
}

void analogRGB(int RGB) {
  Serial.print("LED ");
  Serial.print(RGB);
  Serial.println(" pin 밝기 UP");
  for(int i = 0; i < 256; i++) {
    analogWrite(RGB, i);
    delay(10);
  }
}

void analogOFF() {
  analogWrite(RLED, 0);
  analogWrite(GLED, 0);
  analogWrite(BLED, 0);
  delay(1000);
}

void analogLED() {
  // LED 의 밝기가 점점 밝아짐.
  Serial.println("LED 밝기 UP");
  for(int i = 0; i < 256; i++) {
    analogWrite(LED, i);
    delay(10);
  }

   // LED 의 밝기가 점점 어두워짐.
   Serial.println("LED 밝기 DOWN");
  for(int i = 255; i >= 0; i--) {
    analogWrite(LED, i);
    delay(10);
  }
}
