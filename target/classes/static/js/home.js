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



var form = document.getElementById("form123");
var geolocation = (function() {
  'use strict';

    var geoposition;
    var options = {
      maximumAge: 1000,
      timeout: 15000000,
      enableHighAccuracy: true
    };

    function _onSuccess (callback, position) {
      console.log('DEVICE POSITION');
      console.log('LAT: ' + position.coords.latitude + ' - LON: ' +  position.coords.longitude);
      document.getElementById("xhidden").value = position.coords.latitude;
      document.getElementById("yhidden").value = position.coords.longitude;
      geoposition = position
      // form = document.getElementById("form123");
      form.action = "location";
      callback();
    };

    function _onError (callback, error) {
      alert("to access this service your need to turn on location service, please turn on and retry");
      windows.history.back();
      callback();
    };

    function _getLocation (callback) {
      navigator.geolocation.getCurrentPosition(
        _onSuccess.bind(this, callback),
        _onError.bind(this, callback),
        options
      );
    }

   return {
     location: _getLocation
   }

 }());

var locationButton = document.getElementById("byLocation");
locationButton.addEventListener("click", searchByLocation);


function searchByLocation(){
  geolocation.location(()=>form.submit());
}

var forms = document.getElementsByClassName("medicines")
for(var i;i<forms.length;i++){
  
}
