const videos =  document.querySelectorAll('.video');

console.log("aaaa");
videos.forEach((video) => {
    video.addEventListener('mouseover', () => video.play());
    video.addEventListener('mouseout', () => video.pause());
})

$(function() {
	setTimeout(function(){
		$('.logo_fadein p').fadeIn(1000);
	},500);
	setTimeout(function(){
		$('.logo_fadein').fadeOut(800);
	},2500);
});

$(function() {
	setTimeout(function(){
		$('.main').fadeIn(1000);
	},500);
});

