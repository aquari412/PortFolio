const videos = document.querySelectorAll('.video');

console.log("aaaa");
videos.forEach((video) => {
	video.addEventListener('mouseover', () => video.play()); //カーソルを乗せたとき動画再生
	video.addEventListener('mouseout', () => video.pause()); //カーソルを離したとき再生停止
})
if (window.matchMedia('(max-width: 1100px)').matches) {
	setTimeout(function () {
		$('.logo_fadein').fadeOut(800); //ロゴのフェードアウト
	}, 300);
	$(function () {
		setTimeout(function () {
			$('.main').fadeIn(1000); //メイン画面のフェードイン
		}, 1000);
	});
} else {
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

}

document.addEventListener('mousemove', (event) => {
	const container = document.querySelector('.BackgroundMove');
	const width = window.innerWidth;
	const height = window.innerHeight;

	// マウスの位置を取得
	const mouseX = event.clientX;
	const mouseY = event.clientY;

	// マウスの位置に応じた背景位置を計算
	const bgPosX = (mouseX / width) * 10 + 45; // 中心に対する微調整
	const bgPosY = (mouseY / height) * 10 + 45; // 中心に対する微調整

	// 背景位置を更新
	container.style.backgroundPosition = `${bgPosX}% ${bgPosY}%`;
});

