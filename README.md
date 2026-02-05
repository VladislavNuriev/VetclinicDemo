# Ветеринарная клиника — Android‑приложение

![Screen_recording_20260205_221149](https://github.com/user-attachments/assets/2335accf-1697-4547-a183-1e99c0bcaa0e)


## 📱 Основной функционал

- **Клиенты**  
  - поиск по клиента базе (номер телефона и фамилия) (реализовано);
  - добавление новых клиентов (реализовано);
  - просмотр деталей профиля.

- **Медкарты**  
  - создание медицинских карт животных;
  - привязка карты к конкретному клиенту.

- **Записи на приём**  
  - оформление записи к ветеринарному врачу;
  - хранение даты, специалиста и описания визита.


## 🗄️ База данных (Room)

3 связанные таблицы:

    clients - данные клиентов (телефон, ФИО)

    medical_cards - карты животных (вид, кличка, возраст)

    appointments - записи на прием (дата, врач, описание)

Связь: clients 1→* medical_cards 1→* appointments

<img width="590" height="260" alt="изображение" src="https://github.com/user-attachments/assets/e23e734e-021f-46e8-83ed-7cc6fdd35f98" />


## Технологический стек
  - Язык: Kotlin

  - UI: Jetpack Compose + Material 3

  - Архитектура: Clean Architecture (MVVM + MVI)

  - Локальная БД: Room + Coroutines Flow

  - DI: Dagger Hilt

  - Многомодульность: 5 модулей (app, core, domain, data, feature)

