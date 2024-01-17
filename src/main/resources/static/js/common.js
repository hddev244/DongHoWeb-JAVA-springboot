/**
 * 
 */
window.addEventListener('scroll', function() {
	const navbar = document.getElementById('navbar');
	const headerContainer = document.getElementById('headerContainer');
	const scrollPosition = window.scrollY;
	console.log(scrollPosition)
	if (scrollPosition >= 36) {
		navbar.classList.add("h-0")
		headerContainer.style.position = 'fixed';
		headerContainer.style.top = '0';
	} else {
		headerContainer.style.position = 'relative';
		navbar.classList.remove("h-0")
	}
});

let checkLoginClicked = false;
const handleNavLoginBtn = () => {
	const loginContainer = document.getElementById("loginContainer");
	const loginContainer2 = document.getElementById("loginContainer2");
	if (!checkLoginClicked) {
		loginContainer.classList.add("flex");
		loginContainer.classList.remove("hidden");
		loginContainer2.classList.add("flex");
		loginContainer2.classList.remove("hidden");
	} else {
		loginContainer.classList.remove("flex");
		loginContainer.classList.add("hidden");
		loginContainer2.classList.remove("flex");
		loginContainer2.classList.add("hidden");
	}
	checkLoginClicked = !checkLoginClicked;
}

const handleLoginBtn = () =>{
	handleNavLoginBtn();
}
