# Teacher-Student Course Backend

Bu proje, öğretmen ve öğrenci yönetimi yapılabilen basit bir kurs takip sisteminin backend kısmını oluşturuyor. Java ve Spring Boot kullanarak REST API geliştirdim. Sistemin amacı, öğretmen ve öğrencileri ekleyip silebilmek, dersleri tanımlayıp öğretmenlerle ilişkilendirebilmek.

## Özellikler

- Öğretmen ekleme, silme, güncelleme
- Öğrenci ekleme, silme, güncelleme
- Ders oluşturma ve silme
- Öğretmenlerin hangi derslere gireceğini atama
- Öğretmen ve öğrenci listesinin ayrı ayrı alınabilmesi
- Bir öğretmenin hangi dersleri verdiğinin listelenebilmesi

Kısacası, bir kurs merkezinin veya okulun en temel öğretmen-öğrenci-ders ilişki yönetimini sağlamayı hedefliyor. Sistemde öğretmen ve öğrenci kayıtları ayrı ayrı tutuluyor. Ders kayıtları oluşturulabiliyor ve her derse bir öğretmen atanabiliyor. Öğretmen veya ders silindiğinde ilişkiler de güncelleniyor.

## Teknolojiler

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
