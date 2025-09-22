import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./components/inicio/inicio.component').then(m => m.InicioComponent)
  },
  { path: '**', redirectTo: '' }
  ];
