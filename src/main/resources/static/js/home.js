function navDropDown() {
	if (
		document.getElementById("dropdown").style.getPropertyValue("display") ===
		"none"
	) {
		document.getElementById("dropdown").style.flexDirection = "column";
		document.getElementById("dropdown").style.display = "block";
	} else {
		document.getElementById("dropdown").style.display = "none";
	}
}

function resize() {
	var w = window.innerWidth;
	if (w >= 640) {
		document.getElementById("dropdown").style.display = "flex";
		document.getElementById("dropdown").style.flexDirection = "row";
	} else {
		document.getElementById("dropdown").style.display = "none";
	}
}

var form = document.getElementById("form123");
var user_lon = undefined;
var user_lat = undefined;

var geolocation = (function () {
	"use strict";

	var geoposition;
	var options = {
		maximumAge: 1000,
		timeout: 15000000,
		enableHighAccuracy: true,
	};

    function _onError (callback, error) {
      alert("to access this service your need to turn on location service, please turn on and retry");
      windows.history.back();
      callback();
    };

	function _onSuccess(callback, position) {
		user_lat = position.coords.latitude;
		user_lon = position.coords.longitude;

		document.getElementById("xhidden").value = position.coords.latitude;
		document.getElementById("yhidden").value = position.coords.longitude;
		geoposition = position;
		form.action = "location";
		callback();
	}

	function _getLocation(callback) {
		navigator.geolocation.getCurrentPosition(
			_onSuccess.bind(this, callback),
			_onError.bind(this, callback),
			options
		);
	}

	return {
		location: _getLocation,
	};
})();

var locationButton = document.getElementById("byLocation");
locationButton.addEventListener("click", searchByLocation);

function searchByLocation() {
	geolocation.location(() => form.submit());
}

var forms = document.getElementsByClassName("medicines");
for (var i; i < forms.length; i++) {}

// adding map view
for (var i = 0; i < coordinates.length; i++) {
	name = coordinates[i][0];
	lat = coordinates[i][1];
	lon = coordinates[i][2];
	id = coordinates[i][3];

	console.log(user_lat, user_lon);
	if (user_lon == undefined || user_lat == undefined) {
		var map = L.map("map" + id).setView([parseFloat(lon), parseFloat(lat)], 25);
		L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
			attribution:
				'&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
		}).addTo(map);
		L.marker([parseFloat(lon), parseFloat(lat)], { title: name }).addTo(map);
	} else {
		var map = L.map("map" + id).setView([user_lon, user_lat], 25);
		L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
			attribution:
				'&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
		}).addTo(map);
		L.Routing.control({
			waypoints: [
				L.latLng(parseFloat(lat), parseFloat(lon)),
				L.latLng(parseFloat(user_lat), parseFloat(user_lon)),
			],
			autoRoute: true,
			lineOptions: {
				styles: [{ color: "green", opacity: 0.6, weight: 5 }],
			},
			router: new L.Routing.OSRMv1({
				profile: "foot",
			}),
			createMarker: function (i, wp, nWps) {
				switch (i) {
					case 0:
						return new L.marker(wp.latLng, {
							draggable: true,
						})
							.bindPopup(name)
							.openPopup();
					case nWps - 1:
						return new L.marker(wp.latLng, {
							draggable: true,
						})
							.bindPopup("My Location")
							.openPopup();
				}
			},
		}).addTo(map);
	}
}
