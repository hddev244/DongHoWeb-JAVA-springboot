const loginBtn = document.getElementById('login-btn');
const regBtn = document.getElementById('reg-btn');
const loginForm = document.getElementById('login-form');
const regForm = document.getElementById('register-form');
const checkLocatedForm = document.getElementById('locationForm').getAttribute('data-locationForm');

const onloadFirst = (checkLocatedForm) => {
            console.log("located"+checkLocatedForm)
            if (checkLocatedForm == true || checkLocatedForm == "") {
                  regForm.style.display = 'none';
            } else {
                  loginForm.style.display = 'none';
            }
      }

onloadFirst(checkLocatedForm);

loginBtn.addEventListener('click', () => {
      loginForm.style.display = 'flex';
      regForm.style.display = 'none';
});

regBtn.addEventListener('click', () => {
      regForm.style.display = 'flex';
      loginForm.style.display = 'none';
});