$(document).ready(function() {
    $.ajax({
        url2: "http://rest-service.guides.spring.io/greeting",
        url:  "https://real-customer.herokuapp.com/qrByProduct/1"
    }).then(function(data) {
        $('.greeting-id').append(data.id);
        $('.greeting-content').append(data.name);
    });
});