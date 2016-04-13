$(document).ready(function() {

    var items = Array(
	'You can\'t have everything. Where would you put it?',
	'I went to a restaurant that serves \"breakfast at any time\". So I ordered French Toast during the Renaissance.',
	'What\'s another word for Thesaurus?',
	'I intend to live forever. So far, so good.',
	'I couldn\'t repair your brakes, so I made your horn louder.',
	'Curiosity killed the cat. But for a while I was a suspect.');
    var item = items[Math.floor(Math.random() * items.length)];

    $('#show').text(item);

});
//});

//$(document).ready(function() {  
//    var min = 120000, max = 180000;
//    var delay = Math.floor(Math.random() * (max - min) + min);

//    $('#popup-main').hide().delay(delay).fadeIn(500)
//});
