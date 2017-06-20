[![](https://jitpack.io/v/serkansekman/EtiyaProgressView.svg)](https://jitpack.io/#serkansekman/EtiyaProgressView)


# EtiyaProgressView

[*EtiyaProgressView*](https://github.com/serkansekman/EtiyaProgressView)  Android için hazırlanmış dairesel grafikte gösterilebilecek temel rapor kriterlerine uygun altyapıyı sunmaktadır.

### Örnek Ekran Görüntüsü

<img src="https://media.giphy.com/media/3og0Iw0HPotNtJXoTS/giphy.gif">

<img src="http://i.imgur.com/zx3apaX.jpg">

### Kullanım Şekli

```java
EtiyaProgressView etiyaProgressView;
        etiyaProgressView = (EtiyaProgressView) findViewById(R.id.etiyaProgressView);

        etiyaProgressView.setProgress(40);
        etiyaProgressView.setProgressColor(ContextCompat.getColor(this, R.color.progress_color));
        etiyaProgressView.setTextColor(ContextCompat.getColor(this, R.color.progress_color));
        etiyaProgressView.setPercentageColor(ContextCompat.getColor(this, R.color.progress_color));
        etiyaProgressView.setInnerCircleMargin(-1);
        etiyaProgressView.setInnerCircleColor(ContextCompat.getColor(this, R.color.inner_circle_color));
        etiyaProgressView.setOuterCircleColor(ContextCompat.getColor(this, R.color.inner_circle_color));
        etiyaProgressView.setPercentageText("%");
        etiyaProgressView.setStartAngle(270);
        etiyaProgressView.setMaxProgress(100);
 ```  
 
 <img src="http://i.imgur.com/T5oimsh.jpg">

### Özellikler

Zorunlu özellik tanımlaması gerekmemektedir. Toplam 10 özellik parametrik olarak değiştiriliebilir.

* **setProgress:** Progress değeridir, default değeri 0 olarak gelecektir.

* **setMaxProgress:** Maksimum Progress değeridir, default değeri 100 üzerinden hesaplanacaktır.

* **setStartAngle:** Progress başlangıç noktasını belirler, default değeri 270'dir.

* **setInnerCircleMargin:** Progress dışındaki çemberin içerdeki çembere olan uzaklığı. default değeri -1'dir.

* **setPercentageText:** Progress değerinin oransal sembolüdür, default değeri % olarak tanımlıdır.

* **setProgressColor:** Progress seçili alanının renk değeridir. ContextCompat.getColor(this, R.color.your_color) şeklinde değer atanmalıdır.

* **setTextColor:** Progress seçili alanının değerinin belirtildiği text renk değeridir.

* **setPercentageColor:** Progress değerinin oransal sembolünün renk değeridir.

* **setInnerCircleColor:** Progress seçili alanın dışında kalan kısmın renk değeridir.

* **setOuterCircleColor:** Progress dışındaki çemberin renk değeridir.



### En Kısa Kullanım Şekli

```java
	EtiyaProgressView etiyaProgressView;
        etiyaProgressView = (EtiyaProgressView) findViewById(R.id.etiyaProgressView);
        etiyaProgressView.setProgress(40);
```
2017 Etiya Progress View for Android (http://www.etiya.com) - Serkan Sekman 

### Kurulum

**Gradle**

 ```java
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  
  ```java
  dependencies {
	      compile 'com.github.serkansekman:EtiyaProgressView:1.0'
	}
  ```

# Contact
 - Serkan Sekman
 - Twitter [@brfnsbl](https://twitter.com/brfnsbl)
 - LinkedIn https://www.linkedin.com/in/serkan-sekman-60104976/
 
 
# Inspiration 
https://github.com/serkansekman/EtiyaProgressView
 
# License
EtiyaProgressView is released under the [MIT License.](https://opensource.org/licenses/MIT)
