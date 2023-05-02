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

});
