﻿NOTES
Реализовано приложение Notes-list, для отображения списка заметок.
Показывается список уже созданных заметок (с пейджингом по 10 заметок на
странице). Каждую из них можно редактировать, добавлять новые, отмечать как
«Выполнено», удалять. Список можно фильтровать как «Все заметки», «Только
невыполненные», «Выполненные».

Заметки хранятся в базе.

Кроме фильтрации есть возможность сортировки заметок по
дате создания. Сортировка производится кликом по заголоку поля "Date": одно нажатие
производит сортировку по возрастанию, повторное - по убыванию. При дальнейших нажатиях
происходит реверсирование сортировки.

Клик по "All notes" сбрасывает фильтр и сортировку.

SQL скрипт - test_db в директории db.

Приложение запускается автоматически при старте. Страница приложения http://localhost:8080/notes.