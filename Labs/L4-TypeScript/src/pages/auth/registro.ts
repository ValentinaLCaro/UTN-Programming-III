import type { IUser } from "../../types/user";

const formRegistro = document.getElementById('form-registro') as HTMLFormElement;

formRegistro?.addEventListener('submit', (e) => {
    e.preventDefault();

    const email = (document.getElementById('reg-email') as HTMLInputElement).value;
    const password = (document.getElementById('reg-password') as HTMLInputElement).value;

    const userStorage = localStorage.getItem('users');
    const users: IUser[] = userStorage ? JSON.parse(userStorage) : [];

    const existe = users.find(u => u.email === email);
    if (existe){
        alert("Este email ya está registrado.");
        return;
    }

    const newUser: IUser = { email, password, rol: 'client'};
    users.push(newUser);

    localStorage.setItem('users', JSON.stringify(users));

    alert("Registro exitoso. Ya puede iniciar sesión");
    window.location.href = 'login.html';
})