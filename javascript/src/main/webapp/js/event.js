/**
 * event.js
 */

document.addEventListener('DOMContentLoaded', function () {
    
    const itemInput = document.querySelector('input#itemInput');
    const btnInput = document.querySelector('button#btnInput');
    const itemList = document.querySelector('ul#itemList');
    
    btnInput.addEventListener('click', function () {
        // input에 입력된 값을 읽음.
        const value = itemInput.value;
        // console.log(value);
        
        // input에 입력된 값으로 li 요소를 만듦.
        const item = `<li>${value}</li>`;
        
        // li 요소를 ul에 추가.
        itemList.innerHTML += item;
        
        // input의 값을 지움.
        itemInput.value = '';
        
        // input에 포커스를 줌.
        itemInput.focus();
    });
    
});
