$(document).ready(function() {
    $.ajax({
        url:  "http://localhost:8080/qrByProduct?id=1"

    }).then(function(data) {
        $('.greeting-id').append(data.id);
        $('.greeting-content').append(data.name);
    });
});