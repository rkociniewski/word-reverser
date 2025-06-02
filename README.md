# Word Reverser

[![version](https://img.shields.io/badge/version-1.0.1-yellow.svg)](https://semver.org)
[![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin)
[![Build](https://github.com/rkociniewski/word-reverser/actions/workflows/main.yml/badge.svg)](https://github.com/rkociniewski/word-reverser/actions/workflows/main.yml)
[![codecov](https://codecov.io/gh/rkociniewski/word-reverser/branch/main/graph/badge.svg)](https://codecov.io/gh/rkociniewski/word-reverser)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.21-blueviolet?logo=kotlin)](https://kotlinlang.org/)
[![Gradle](https://img.shields.io/badge/Gradle-8.14.1-blue?logo=gradle)](https://gradle.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-greem.svg)](https://opensource.org/licenses/MIT)


## Description

A simple Kotlin utility that provides string extensions for:

- Reversing the letters of each word without changing their order.
- Reversing the order of words while preserving punctuation.

## Features

- Handles punctuation and multiple whitespace types (spaces, tabs, newlines).
- Unicode-aware.
- Includes extensive test coverage with JUnit 5.

## Example

```kotlin
"Hello world!".reverseLettering()
// Output: "olleH dlrow!"

"Hello world!".reverseWordsOrder()
// Output: "world! Hello"
````

## Functions

### `String.reverseLettering()`

Reverses the characters in each word but keeps the original word order.

### `String.reverseWordsOrder()`

Reverses the order of words in the sentence.

## Installation

Clone the repository and use with any Kotlin/Java project that supports Gradle.

```bash
git clone https://github.com/your-username/word-reverser.git
```

## Testing

The project uses JUnit 5 for unit testing.

```bash
./gradlew test
```

## License

This project is licensed under the MIT License.

## Built With

* [Gradle](https://gradle.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Rafał Kociniewski** - [PowerMilk](https://github.com/rkociniewski)
