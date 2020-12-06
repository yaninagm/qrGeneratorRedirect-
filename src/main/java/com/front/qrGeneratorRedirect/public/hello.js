$(document).ready(function() {
    $.ajax({
        url: "https://cors-anywhere.herokuapp.com" + "https://real-customer.herokuapp.com/qrByProduct/1"
    }).then(function(data) {
        $('.greeting-id').append(data.id);
        $('.greeting-content').append(data.content);
    });
});