for (var i = 0; i < coordinates.length; i++) {
	name = coordinates[i][0];
	lat = coordinates[i][1];
	lon = coordinates[i][2];
	id = coordinates[i][3];

	var map = L.map("map" + id).setView(
		[parseFloat(user_lon), parseFloat(user_lat)],
		25
	);
	// var map = L.map("map" + id).setView([lon, lat], 10);

	L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
		attribution:
			'&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
	}).addTo(map);
	// L.Routing.control({
	// 	waypoints: [
	// 		L.latLng(parseFloat(lat), parseFloat(lon)),
	// 		L.latLng(parseFloat(user_lat), parseFloat(user_lon)),
	// 	],
	// 	autoRoute: true,
	// 	lineOptions: {
	// 		styles: [{ color: "green", opacity: 0.6, weight: 5 }],
	// 	},
	// 	router: new L.Routing.OSRMv1({
	// 		profile: "foot",
	// 	}),
	// 	createMarker: function (i, wp, nWps) {
	// 		switch (i) {
	// 			case 0:
	// 				return new L.marker(wp.latLng, {
	// 					draggable: true,
	// 				})
	// 					.bindPopup(name)
	// 					.openPopup();
	// 			case nWps - 1:
	// 				return new L.marker(wp.latLng, {
	// 					draggable: true,
	// 				})
	// 					.bindPopup("My Location")
	// 					.openPopup();
	// 		}
	// 	},
	// }).addTo(map);
}
