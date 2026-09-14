import './style.css';
import { verificarSesion, cerrarSesion } from './utils/authGuard';

verificarSesion();

const btnLogout = document.getElementById('btn-logout');
btnLogout?.addEventListener('click', (e) => {
    e.preventDefault();
    cerrarSesion();
});
