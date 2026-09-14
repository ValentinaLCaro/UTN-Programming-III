import type { IUser } from '../../types/user';
import '../../style.css';

const formRegistro = document.getElementById('form-registro') as HTMLFormElement;

formRegistro?.addEventListener('submit', (e) => {
    e.preventDefault();

    const email = (document.getElementById('reg-email') as HTMLInputElement).value;
    const password = (document.getElementById('reg-password') as HTMLInputElement).value;

    const usersStorage = localStorage.getItem('users');
    const users: IUser[] = usersStorage ? JSON.parse(usersStorage) : [];

    const existe = users.find(u => u.email === email);
    if (existe) {
        alert("Ese email ya está registrado.");
        return;
    }

    const newUser: IUser = { email, password, rol: 'client' };
    users.push(newUser);

    localStorage.setItem('users', JSON.stringify(users));
    
    alert("Registro exitoso. Ahora podés iniciar sesión.");
    window.location.href = 'login.html';
});
