function navDropDown(){
    if (document.getElementById("dropdown").style.getPropertyValue("display")==="none"){
            document.getElementById("dropdown").style.flexDirection="column"
            document.getElementById("dropdown").style.display="block"
    }
    else{
            document.getElementById("dropdown").style.display="none"
    }
}

function resize(){
    var w = window.innerWidth;
    if (w>=640){
        document.getElementById("dropdown").style.display="flex"
        document.getElementById("dropdown").style.flexDirection="row"
    }
    else{
        document.getElementById("dropdown").style.display="none"
    }
}