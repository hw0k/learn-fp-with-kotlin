# 함수형 프로그래밍이란?

## 순수 함수

순수 함수는 다음의 2가지 조건을 충족해야 합니다.

- 동일한 입력으로 호출하면 항상 동일한 출력을 보장해야 한다.
- 사이드 이펙트가 없다.

위 두 가지 조건을 하나라도 충족하지 못한 함수를 비순수 함수라고 합니다. 비순수 함수를 사용하는 함수 또한 비순수 함수입니다.

## 사이드 이펙트 없는 프로그램

- `sec3/pure-impure-function.kt`
- `sec3/mutable-immutable.kt`

## 참조 투명성

- `sec4/referential-transparency.kt`

## 일급 함수

- `sec5/first-class.kt`
- `sec5/calculator.kt`
