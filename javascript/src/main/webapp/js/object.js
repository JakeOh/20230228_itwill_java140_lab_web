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
    
    // 메서드를 갖는 객체:
    const score = {
        korean: 100,
        english: 90,
        math: 70,
        sum: function () {
            return this.korean + this.english + this.math;
        },
        mean: function () {
            return this.sum() / 3;
        },
    };
    console.log(score);
    console.log(score.sum()); // 메서드 호출
    console.log(score.mean());
    
    // 생성자 함수:
    function Score(korean, english, math) {
        // 필드
        this.korean = korean;
        this.english = english;
        this.math = math;
        
        // 메서드
        this.sum = function () {
            return this.korean + this.english + this.math;
        };
        this.mean = function () {
            return this.sum() / 3;
        };
    }
    
    // 생성자 함수 호출:
    const score1 = new Score(10, 20, 30); // 객체 생성
    console.log(score1);
    console.log(score1.sum()); // 객체 메서드 호출
    console.log(score1.mean());
    
    const score2 = new Score(90, 95, 89);
    console.log(score2);
    console.log(score2.sum());
    console.log(score2.mean());
    
});
