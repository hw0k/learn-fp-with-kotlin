# learn-fp-with-kotlin
도서 &lt;코틀린으로 배우는 함수형 프로그래밍> 스터디용 레포지토리


### 함수형 프로그래밍 서론

함수형 프로그래밍은, **immutable, referential transparency, first-class function, lazy evaluation** 4가지의 특징을 가지고 있습니다.

- immutable: 불변성, 어떤 값이 변하지 않는 것을 보장함.
- referential transparency: 참조 투명성, 프로그램의 변경 없이도 어떤 표현식을 값으로 대체할 수 있음.
  - 예를 들어, f(x) -> y인 함수가 있으면 f(x)는 y로 대체할 수 있음.
- first-class function: 일급 함수
  - 함수를 함수의 매개변수로 넘길 수 있음.
  - 함수를 함수의 반환값으로 돌려줄 수 있음.
  - 함수를 변수나 자료구조에 담을 수 있음.
- lazy evaluation: 게으른 평가, 시작 시점이 아닌 호출 시점에 값을 계산함.

함수형 프로그래밍으로 개발했을 때 여러 이점이 생기는데, 그 중 대표적으로 4가지 이점이 있습니다.

  - 사이드 이펙트가 없는 프로그램을 만들어 concurrency(동시성) programming에 적합함.
  - 코드의 복잡도가 감소하여 간결한 코드를 만들 수 있음.
  - 모듈성이 높아져 유지보수에 용이함.
  - 예측 불가능한 경우를 줄여 컴파일러에 친화적인 코드를 만들 수 있음.

### 그래서, 언제 공부하나요?

언제마다 할 지는 정해지지 않지만, 마음 잡고 할 때는 2시간씩 공부하려고 합니다. 본업이 있어 하루종일을 잡고 공부하기에는 부담이 가기 마련이죠 :)

### 개발 환경을 설명해주세요!

- Kotlin
- VSCode
  - `.vscode/extensions.json` 파일에 권장 extension을 세팅했습니다.
  - Kotlin IDE for VSCode의 도움
  - Code Runner로 디버깅, 실행
