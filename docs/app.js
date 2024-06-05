const videos = document.querySelectorAll('.video');

console.log("aaaa");
videos.forEach((video) => {
	video.addEventListener('mouseover', () => video.play()); //カーソルを乗せたとき動画再生
	video.addEventListener('mouseout', () => video.pause()); //カーソルを離したとき再生停止
})

$(function () {
	setTimeout(function () {
		$('.logo_fadein p').fadeIn(1000); //ロゴのフェードイン
	}, 500);
	setTimeout(function () {
		$('.logo_fadein').fadeOut(800); //ロゴのフェードアウト
	}, 2500);
});

$(function () {
	setTimeout(function () {
		$('.main').fadeIn(1000); //メイン画面のフェードイン
	}, 500);
});

