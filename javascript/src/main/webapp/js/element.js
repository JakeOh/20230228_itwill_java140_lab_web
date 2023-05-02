/**
 * element.js
 */

// HTML 문서에 'DOMContentLoaded' 이벤트 리스너를 등록.
// 브라우저가 HTML 문서의 모든 요소들을 생성하고 난 후, 이벤트 리스너 함수를 실행.
document.addEventListener('DOMContentLoaded', function () {
    
    // id로 HTML 요소를 찾음:
    const btn1 = document.getElementById('btn1');
    // console.log(btn1);
    
    // 찾은 HTML 요소에 'click' 이벤트 리스너를 등록:
    // addEventListener('eventName', callback);
    // callback: 이벤트가 발생했을 때 브라우저가 호출하는 함수. 이벤트를 처리하는 함수.
    btn1.addEventListener('click', function () {
        // id="d1"인 요소를 찾아서 바탕색을 변경
        const d1 = document.getElementById('d1');
        d1.style.backgroundColor = 'lavender';
    });
    
    // id='btn2' 버튼에 'click' 이벤트 리스너를 등록:
    const btn2 = document.getElementById('btn2');
    btn2.addEventListener('click', function () {
        // class="c1"인 요소들의 바탕색을 lime으로 변경
        const divisions = document.getElementsByClassName('c1');
        // console.log(divisions);
        for (let element of divisions) {
            // console.log(element);
            element.style.backgroundColor = 'lime';
        }
    });
    
    // id="btn3"인 버튼에 'click' 이벤트 리스너를 등록:
    const btn3 = document.getElementById('btn3');
    btn3.addEventListener('click', function () {
        // tag 이름이 div인 모든 요소의 바탕색을 변경:
        const divisions = document.getElementsByTagName('div');
        for (let div of divisions) {
            div.style.backgroundColor = 'lightpink';
        }
    });
    
    // CSS selector(선택자) 문법을 argument로 사용하는 메서드:
    // tagName, .className, #id, tagName.className#id
    // parent descendent: 자손 요소 찾기
    // parent > child: 자식 요소 찾기
    // element:peudo-selector: (예) button:hover, tr:nth-child(odd)
    
    // document.querySelector(selector): selector로 찾을 수 있는 "첫번째" 요소를 리턴.
    // document.querySelectorAll(selector): selector로 찾을 수 있는 "모든" 요소들의 collection을 리턴.
    
    const btn4 = document.querySelector('#btn4');
    btn4.addEventListener('click', function () {
        const division = document.querySelector('.c2');
        // console.log(division);
        division.style.backgroundColor = 'crimson';
    });
    
    const btn5 = document.querySelector('#btn5');
    btn5.addEventListener('click', function () {
        const divisions = document.querySelectorAll('.c2');
        // console.log(divisions);
        for (let d of divisions) {
            d.style.backgroundColor = 'DodgerBlue';
        }
    });

});
