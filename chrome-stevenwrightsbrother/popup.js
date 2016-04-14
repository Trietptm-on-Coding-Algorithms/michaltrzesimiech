$(document).ready(function() {

    var items = Array(
	'You can\'t have everything. Where would you put it?',
	'I went to a restaurant that serves \"breakfast at any time\". So I ordered French Toast during the Renaissance.',
	'What\'s another word for Thesaurus?',
	'I intend to live forever. So far, so good.',
	'I couldn\'t repair your brakes, so I made your horn louder.',
	'Driving hasn\'t been the same since I installed fun-house rearview mirrors.',
	'Anywhere is walking distance, if you\'ve got the time.',
	'I want to get a tattoo of myself on my entire body, only two inches taller.',
	'I saw a bank that said \'24 Hour Banking\' but I don\'t have that much time.',
	'If at first you don\'t succeed then skydiving definitely isn\'t for you.',
	'I bought some batteries, but they weren\'t included.',
	'I was reading the dictionary. I thought it was a poem about everything.',
	'I went to a general store but they wouldn\'t let me buy anything specific.',
	'I\'m writing a book. I\'ve got the page numbers done.',
	'How young can you die of old age?',
	'If at first you don\'t succeed, destroy all evidence that you tried.',
	'I named my dog Stay so I can say, \"Come here, Stay. Come here, Stay.\"',
	'A lot of people are afraid of heights. Not me, I\'m afraid of widths.',
	'Curiosity killed the cat. But for a while I was a suspect.');
    
    var item = items[Math.floor(Math.random() * items.length)];

    $('#show').text(item);

});
