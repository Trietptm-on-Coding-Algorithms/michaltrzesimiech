//$(document).ready(function() {

    var items = Array('go west', 'go east', 'go north', 'go upwards', 'go downwards', 'go within');
    var item = items[Math.floor(Math.random() * items.length)];

    $('#show').text(item);

//});
//});

//$(document).ready(function() {  
//    var min = 120000, max = 180000;
//    var delay = Math.floor(Math.random() * (max - min) + min);

//    $('#popup-main').hide().delay(delay).fadeIn(500)
//});
