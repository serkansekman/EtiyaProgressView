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

Zorunlu özellik tanımlanması gerekmemektedir. toplamda 10 özellik parametrik olarak değiştiriliebilir.

* **setProgress:** Progress değeridir, girilmediği taktirde default değer 0 olarak gelecektir.

* **setMaxProgress:** Progress değeridir, girilmediği taktirde default değer 0 olarak gelecektir.




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

