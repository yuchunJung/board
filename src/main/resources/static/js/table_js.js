function showAlert() {

    var boardTitle = document.frm.boardTitle;

    if (boardTitle.value == '') {
        window.alert("제목을 입력하세요");
        document.frm.boardTitle.focus();
        document.getElementById('boardTitle').select();
        return false;
    }

    if (isNaN(document.frm.boardWriter.value)) {
    alert ("숫자를 입력해야 합니다");
    frm.boardWriter.focus();
    return false;
    }

    return true;
}