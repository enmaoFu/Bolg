function signInCheck(src){
    
    var key = document.getElementById('key').value;
    if(key.length == 0){
        alert('key 不能为空');
    }else if(key == 'asd'){
        window.location.href=src;
    }else{
        alert('key 不正确');
    }
    
}