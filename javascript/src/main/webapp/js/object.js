/**
 * object.js
 */

document.addEventListener('DOMContentLoaded', function () {
    // JSON(JavaScript Object Notation): 자바스크립트 객체 표기법.
    // { property: value, ... }
    
    const person = {
        name: '오쌤',
        age: 16,
        phone: ['010-0000-0000', '02-0000-0000'],
    };
    console.log(person);
    
    // 객체의 프로퍼티 접근(사용): (1) 참조 연산자 (2)인덱스 연산자
    console.log(person.name); // person 객체의 name 프로퍼티 값을 읽음.
    console.log(person['age']); // person 객체의 age 프로퍼티 값을 읽음.
    console.log(person.phone)
    console.log(person.phone[0]);
    console.log(person['phone'][1])
    
    person.name = '홍길동'; // person 객체의 name 프로퍼티 값을 변경.
    console.log(person);
    
    // 자바스크립트 객체는 프로퍼티를 추가할 수 있음.
    person.company = '아이티윌';
    console.log(person);
    
    // 객체(object)에서 for-in 구문: 객체의 프로퍼티 이름들을 iteration.
    for (let key in person) {
        console.log(key, ':', person[key]);
    }
    
});
