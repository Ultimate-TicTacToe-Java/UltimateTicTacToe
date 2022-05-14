# Instalacja

Ponieważ miałem spore problemy, żeby odpalić to w mojej konfiguracji (WSL2 Ubuntu 20.04)
zamieszczam sposób w jaki udało się odpalić projek w JetBrains IntelliJ

```sh
sudo apt install openjdk-17-jre-headless
```

```sh
sudo apt install libgtk-3-0
```

Pobrałem też [bibliotekę JavaFX](https://gluonhq.com/products/javafx/) w wersji 18.0.1
i zamieściłem w katalogu `lib/`, żeby nie było problemu z różnicami w wersjach

Z powodu jej rozmiaru (ok. 100 MB) nie wrzucałem jej do repozytorium)

## Otworzenie projektu

```sh
git clone https://github.com/Ultimate-TicTacToe-Java/UltimateTicTacToe
```

1. Otwieramy **UltimateTicTacToe** w IntelliJ za pomocą `File` -> `Open`

2. Dodajemy konfigurację `Add configuration` -> `Application`

- Jako środowisko wybieramy `openjdk-18`

- Z listy po prawej (niebieskiej) `Modify options` wybieramy `Add VM options`

- Do pola `VM Options` wklejamy

```sh
--module-path <root path do projektu>/UltimateTicTacToe/lib/javafx-sdk-18.0.1/lib --add-modules javafx.controls,javafx.fxml`
```

- Z pola `Chose main class` wybieramy `Game`

Zamykamy okno konfiguracji.

3. Dodajemy bibliotekę JavaFX

`File` -> `Project Structure...` -> `Libraries` -> `+` -> `Java`

W polu ze ścieżką wklejamy

```sh
<root path do projektu>/UltimateTicTacToe/lib/javafx-sdk-18.0.1/lib
```

Zamykamy okna

Odpalamy projekt
