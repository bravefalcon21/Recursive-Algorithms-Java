# Recursive Algorithms in Java

پروژهٔ درس طراحی و تحلیل الگوریتم‌ها. هر الگوریتم در یک کلاس مستقل پیاده‌سازی شده است و متد `main` آن یک نمونهٔ ثابت را اجرا می‌کند. پروژه فقط از کتابخانهٔ استاندارد جاوا استفاده می‌کند.

## پیچیدگی الگوریتم‌ها

در سه الگوریتم آرایه‌ای، $n$ تعداد عناصر بازهٔ جاری است. در فاکتوریل و فیبوناچی، $n$ ورودی عددی است و در برج هانوی تعداد دیسک‌هاست. فضای کمکی شامل پشتهٔ بازگشت است. روابط زمانی با فرض هزینهٔ ثابت برای عملیات پایه و چاپ هر حرکت نوشته شده‌اند.

| الگوریتم | رابطهٔ بازگشتی زمان | زمان | فضای کمکی |
|---|---|---|---|
| جست‌وجوی دودویی | $T(n)=T(\lfloor n/2\rfloor)+\Theta(1)$ در بدترین حالت | بدترین $\Theta(\log n)$، بهترین $\Theta(1)$ | بدترین $\Theta(\log n)$ |
| بیشینهٔ بازگشتی | $T(n)=T(\lfloor n/2\rfloor)+T(\lceil n/2\rceil)+\Theta(1)$ | $\Theta(n)$ | $\Theta(\log n)$ |
| مرتب‌سازی ادغامی | $T(n)=T(\lfloor n/2\rfloor)+T(\lceil n/2\rceil)+\Theta(n)$ | $\Theta(n\log n)$ | $\Theta(n)$ |
| فاکتوریل | $T(n)=T(n-1)+\Theta(1)$ | $\Theta(n)$ | $\Theta(n)$ |
| فیبوناچی ساده | $T(n)=T(n-1)+T(n-2)+\Theta(1)$ | $\Theta(\varphi^n)$، $\varphi=(1+\sqrt{5})/2$ | $\Theta(n)$ |
| برج هانوی | $T(n)=2T(n-1)+\Theta(1)$ | $\Theta(2^n)$ | $\Theta(n)$ |

هزینهٔ حالت‌های پایه ثابت است. مرتبه‌های جدول رفتار الگوریتم‌ها را با رشد ورودی در مدل تحلیل نشان می‌دهند. محدودیت نوع دادهٔ `long` در بخش‌های مربوط آمده است.

## کامپایل و اجرا

با JDK 8 یا بالاتر، از ریشهٔ پروژه دستورهای زیر را اجرا کنید. ابتدا پوشهٔ خروجی را بسازید. اگر از قبل وجود دارد، خط اول را رد کنید.

```sh
mkdir out
javac -encoding UTF-8 -d out src/BinarySearch.java src/RecursiveMaximum.java src/MergeSort.java src/Factorial.java src/Fibonacci.java src/TowerOfHanoi.java
java -cp out BinarySearch
java -cp out RecursiveMaximum
java -cp out MergeSort
java -cp out Factorial
java -cp out Fibonacci
java -cp out TowerOfHanoi
```

## ۱. جست‌وجوی دودویی

ورودی یک آرایهٔ مرتب‌شده به ترتیب صعودی است. ابتدا عنصر میانی را بررسی می‌کنیم. اگر هدف کوچک‌تر باشد، در نیمهٔ چپ و اگر بزرگ‌تر باشد، در نیمهٔ راست جست‌وجو می‌کنیم. بازهٔ خالی مقدار `-1` برمی‌گرداند. اندیس‌ها از صفر شروع می‌شوند و اگر هدف تکراری باشد، یکی از رخدادهای آن برگردانده می‌شود. در بدترین حالت پس از $k$ گام، اندازهٔ بازه حداکثر $n/2^k$ است. بنابراین تعداد گام‌ها لگاریتمی است.

```text
SEARCH(A, target, left, right):
    if left > right: return -1
    mid = left + floor((right - left) / 2)
    if A[mid] == target: return mid
    if target < A[mid]: return SEARCH(A, target, left, mid - 1)
    return SEARCH(A, target, mid + 1, right)
```

**نمونه** — جست‌وجوی ۱۱ و سپس ۶ در آرایهٔ `[2, 4, 7, 11, 15]`، به‌ترتیب `3` و `-1` را در دو خط چاپ می‌کند.

## ۲. بیشینهٔ بازگشتی

آرایه باید دست‌کم یک عنصر داشته باشد. هر بازه به دو نیمه تقسیم می‌شود و بیشینهٔ کل از مقایسهٔ بیشینهٔ دو نیمه به دست می‌آید. حالت پایه، بازهٔ تک‌عنصری است. درخت بازگشت $n$ برگ و $n-1$ گره داخلی دارد، پس دقیقاً $n-1$ مقایسهٔ عناصر انجام می‌شود.

```text
MAXIMUM(A, left, right):
    if left == right: return A[left]
    mid = left + floor((right - left) / 2)
    x = MAXIMUM(A, left, mid)
    y = MAXIMUM(A, mid + 1, right)
    return max(x, y)
```

**نمونه** — خروجی برای `[-8, -3, -12, -1, -5]` برابر `-1` است.

## ۳. مرتب‌سازی ادغامی

ابتدا هر نیمه را بازگشتی مرتب می‌کنیم. سپس با دو اشاره‌گر، هر بار کوچک‌ترین عنصر باقی‌مانده را در آرایهٔ کمکی می‌گذاریم و نتیجه را به بازهٔ اصلی برمی‌گردانیم. در حالت برابری، عنصر سمت چپ زودتر انتخاب می‌شود. آرایهٔ کمکی یک بار ساخته می‌شود و همهٔ فراخوانی‌ها از آن استفاده می‌کنند. مجموع هزینهٔ ادغام در هر سطح خطی است و تعداد سطوح لگاریتمی است.

```text
SORT(A):
    B = new array of length A.length
    SORT_RANGE(A, B, 0, A.length - 1)

SORT_RANGE(A, B, left, right):
    if left >= right: return
    mid = left + floor((right - left) / 2)
    SORT_RANGE(A, B, left, mid)
    SORT_RANGE(A, B, mid + 1, right)
    i = left, j = mid + 1, k = left
    while i <= mid and j <= right:
        if A[i] <= A[j]:
            B[k] = A[i]
            i = i + 1
        else:
            B[k] = A[j]
            j = j + 1
        k = k + 1
    append the remaining elements of the nonempty half to B starting at k
    copy B[left..right] back to A[left..right]
```

**نمونه** — ورودی `[9, 3, 7, 3, -2]` به `[-2, 3, 3, 7, 9]` تبدیل می‌شود.

## ۴. فاکتوریل

از رابطهٔ $n!=n(n-1)!$ با حالت‌های پایهٔ $0!=1!=1$ استفاده می‌کنیم. هر فراخوانی مقدار ورودی را یک واحد کاهش می‌دهد، بنابراین تعداد فراخوانی‌ها خطی است. متد بازهٔ ۰ تا ۲۰ را می‌پذیرد، چون $21!$ از بیشینهٔ `long` جاوا بزرگ‌تر است.

```text
FACTORIAL(n):
    if n < 0 or n > 20: raise an error
    if n <= 1: return 1
    return n * FACTORIAL(n - 1)
```

**نمونه** — `factorial(5)` مقدار `120` را برمی‌گرداند.

## ۵. فیبوناچی

با $F_0=0$ و $F_1=1$ شروع می‌کنیم و از $F_n=F_{n-1}+F_{n-2}$ استفاده می‌کنیم. نسخهٔ ساده زیرمسئله‌های مشترک را چندبار محاسبه می‌کند. تعداد کل فراخوانی‌ها $2F_{n+1}-1$ است و با مرتبهٔ $\Theta(\varphi^n)$ رشد می‌کند. بازهٔ قابل نمایش در `long` از ۰ تا ۹۲ است، اما برای اجرای این نسخه باید از ورودی‌های کوچک استفاده کرد.

```text
FIBONACCI(n):
    if n < 0 or n > 92: raise an error
    if n <= 1: return n
    return FIBONACCI(n - 1) + FIBONACCI(n - 2)
```

**نمونه** — `fibonacci(10)` مقدار `55` را برمی‌گرداند.

## ۶. برج هانوی

سه میلهٔ متمایز داریم. هر حرکت فقط یک دیسک را جابه‌جا می‌کند و دیسک بزرگ‌تر روی دیسک کوچک‌تر قرار نمی‌گیرد. ابتدا $n-1$ دیسک را از مبدأ به میلهٔ کمکی می‌بریم، سپس بزرگ‌ترین دیسک را به مقصد می‌بریم و در پایان $n-1$ دیسک را از میلهٔ کمکی به مقصد منتقل می‌کنیم. تعداد حرکت‌ها از رابطهٔ $M(n)=2M(n-1)+1$ و $M(0)=0$ به دست می‌آید و برابر $2^n-1$ است. حرکت‌ها مستقیماً چاپ می‌شوند.

```text
HANOI(n, source, auxiliary, destination):
    if n < 0: raise an error
    if n == 0: return
    HANOI(n - 1, source, destination, auxiliary)
    print move disk n from source to destination
    HANOI(n - 1, auxiliary, source, destination)
```

**نمونه** — برای انتقال سه دیسک از A به C با کمک B، خروجی برنامه چنین است.

```text
Move disk 1: A -> C
Move disk 2: A -> B
Move disk 1: C -> B
Move disk 3: A -> C
Move disk 1: B -> A
Move disk 2: B -> C
Move disk 1: A -> C
```
