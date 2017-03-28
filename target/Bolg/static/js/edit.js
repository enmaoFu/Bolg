function getcontent(){
    
    var title = document.getElementById('title').value;
    var introduce = document.getElementById('introduce').value;
    var html = ue.getContent();
    if(title == ''){
        alert('标题不能为空');
    }else if(introduce == ''){
        alert('介绍不能为空');
    }else if(html == ''){
        alert('内容不能为空');
    }else{
        alert(title + introduce + html);
    }
    
}