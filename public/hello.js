$(document).ready(function() {
    $.ajax({
        url:  "https://real-customer.herokuapp.com/qrByProduct/1",
        headers: { 'Access-Control-Allow-Origin': '*' },
        headers: { 'Origin': 'http://localhost:8080/' },
        headers: { 'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE' },
        headers: { 'Access-Control-Allow-Headers': 'Content-Type' },
        headers: { 'Access-Control-Request-Method': 'GET' },
        headers: { 'Access-Control-Request-Headers': 'Content-Type' }

    }).then(function(data) {
        $('.greeting-id').append(data.id);
        $('.greeting-content').append(data.name);
    });
});