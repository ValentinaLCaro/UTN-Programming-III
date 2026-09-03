import type { IUser } from '../../types/user';

const formLogin = document.getElementById('form-login') as HTMLFormElement;

formLogin?.addEventListener('submit', (e) => {
    e.preventDefault();

    const email = (document.getElementById('log-email') as HTMLInputElement).value;
    const password = (document.getElementById('log-password') as HTMLInputElement).value;

    const usersStorage = localStorage.getItem('users');
    const users: IUser[] = usersStorage ? JSON.parse(usersStorage) : [];

    const userFound = users.find(u => u.email === email && u.password === password);

    if (userFound) {
        localStorage.setItem('userData', JSON.stringify(userFound));
        
        if (userFound.rol === 'admin') {
            window.location.href = '../admin/admin.html';
        } else {
            window.location.href = '../client/index.html';
        }
    } else {
        alert("Email o contraseña incorrectos.");
    }
});