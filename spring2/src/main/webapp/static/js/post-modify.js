/**
 * post-modify.js
 * /post/modify.jsp 에서 사용.
 */

document.addEventListener('DOMContentLoaded', () => {
    
    // 삭제 버튼을 찾아서 이벤트 리스너를 등록.
    const btnDelete = document.querySelector('#btnDelete');
    btnDelete.addEventListener('click', () => {
        // TODO
        alert('삭제');
    });
    
    // 업데이트 버튼을 찾아서 이벤트 리스너를 등록.
    const btnUpdate = document.querySelector('#btnUpdate');
    btnUpdate.addEventListener('click', () => {
        // TODO
        alert('업데이트');
    });
    
});
