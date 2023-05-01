/**
 * function.js
 * 07_function.html에 포함
 */

/*
 JavaScript에서 함수를 선언(정의)하는 방법:
 function 함수이름([파라미터, ...]){
     실행 코드;
     [return [리턴값];]
 }
 
 - 함수의 리턴 타입을 선언하지 않음.
 - 파라미터를 선언할 때 var, const, let 키워드를 사용하지 않음.
*/

// 함수 선언:
function add(x, y) {
    return x + y;
}

// 함수 호출:
let result = add(1, 2);
console.log('result =', result);

// argument: 함수를 호출할 때 함수에 전달하는 값.
// parameter: 전달받은 argument를 저장하기 위한 지역 변수. 함수 선언부에서 선언.

// 자바스크립트 함수는 파라미터의 타입을 검사하지 않음.
result = add('안녕하세요', 'Hello');
console.log(result);

// 자바스크립트 함수는 파라미터 개수를 검사하지 않음.
result = add(10, 20, 30); // 함수 선언의 parameter 개수보다 더 많은 argument를 전달.
console.log('result =', result);

result = add(1); // 함수 선언의 parameter 개수보다 적은 argument를 전달.
// 전달하지 않은 파라미터의 값은 undefined가 됨.
console.log('result =', result); // -> NaN(Not a Number)

// 자바스크립트의 모든 함수는 arguments 이름의 프로퍼티를 가지고 있음.
// 함수 호출에서 전달한 모든 값들을 저장하는 (배열과 비슷한) 객체.
function test() {
    console.log(arguments);
}

test(1);
test(1, 'hello');
