function navDropDown(){
    if (document.getElementById("dropdown").style.getPropertyValue("display")==="block"){
        document.getElementById("dropdown").style.display="none"
    }
    else{
            document.getElementById("dropdown").style.display="block"
            document.getElementById("dropdown").style.flexDirection="column"
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