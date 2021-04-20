// 전역 변수 및 함수 선언
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
}

void loop() {
  bLED0();
  bLED1();
  bLED2();
  bLED3();
  bLED4();
  bLED5();
  bLED6();
  bLED7();
}

void bLED0() {
  digitalWrite(RLED, LOW);
  digitalWrite(GLED, LOW);
  digitalWrite(BLED, LOW);
  delay(1000);
}

void bLED1() {
  digitalWrite(RLED, LOW);
  digitalWrite(GLED, LOW);
  digitalWrite(BLED, HIGH);
  delay(1000);
}

void bLED2() {
  digitalWrite(RLED, LOW);
  digitalWrite(GLED, HIGH);
  digitalWrite(BLED, HIGH);
  delay(1000);
}

void bLED3() {
  digitalWrite(RLED, HIGH);
  digitalWrite(GLED, HIGH);
  digitalWrite(BLED, HIGH);
  delay(1000);
}


void bLED4() {
  digitalWrite(RLED, LOW);
  digitalWrite(GLED, LOW);
  digitalWrite(BLED, LOW);
  delay(1000);
}

void bLED5() {
  digitalWrite(RLED, LOW);
  digitalWrite(GLED, LOW);
  digitalWrite(BLED, HIGH);
  delay(1000);
}

void bLED6() {
  digitalWrite(RLED, LOW);
  digitalWrite(GLED, HIGH);
  digitalWrite(BLED, HIGH);
  delay(1000);
}

void bLED7() {
  digitalWrite(RLED, HIGH);
  digitalWrite(GLED, HIGH);
  digitalWrite(BLED, HIGH);
  delay(1000);
}
