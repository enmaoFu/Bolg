function getMessage(){
    
    var text = quill.getText();
    var delta = quill.getContents();
    alert(text);
    
    var s = document.getElementById('s');
    s.innerHTML = text;
    
}