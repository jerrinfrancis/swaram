var directionDisplay;
var directionsService = new google.maps.DirectionsService();

function initialize() {
    directionsDisplay = new google.maps.DirectionsRenderer();
    var mapOptions = {
        zoom: 9,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        center: new google.maps.LatLng(8.5488, 76.9173)
    };
    var map = new google.maps.Map(document.getElementById('map-canvas'),
            mapOptions);
    directionsDisplay.setMap(map);
    directionsDisplay.setPanel(document.getElementById('directions-panel'));

    var control = document.getElementById('control');
    control.style.display = 'block';
    map.controls[google.maps.ControlPosition.TOP].push(control);

}

function changeSelection(start, end) {
    var selstart = document.getElementById("start");
    var selend = document.getElementById("end");
    selstart.selectedIndex = start;
    selend.selectedIndex = end;
    return true;
}

function setColor(element,color) {
    document.getElementById(element).style.color = color;
    return true;
}

function calcRoute() {
    var start = document.getElementById("start").value;
    var end = document.getElementById("end").value;
    var request = {
        origin: start,
        destination: end,
        travelMode: google.maps.DirectionsTravelMode.DRIVING
    };
    directionsService.route(request, function(response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
        }
    });
    return true;
}