# https-catchylabs-webclient.testinium.com-
Test Planı
Proje Adı:Hesap Yönetim ve Para Transferi Uygulaması
Hazırlayan:Ayhan Kaya
Tarih:09/01/2025
1. Test Amacı
   Uygulamanın hesap oluşturma, para transferi ve kredi kartı üzerinden para
   ekleme gibi temel işlevselliklerini doğrulamak.
2. Test Kapsamı
- Para transferi (Hesaplar arası)
- Kredi kartı ile para ekleme
- Hesap ismi düzenleme
- Hesap bakiyesi kontrolleri
3. Test Ortamı
- Tarayıcı (Chrome, Firefox vb.)
- İnternet bağlantısı
4. Test Stratejisi
- Fonksiyonel Testler
- Kullanıcı Arayüzü Testleri
- Negatif Testler
5. Test Kriterleri
- Başarı kriteri: Her test durumu belirtilen sonuçla sonuçlanırsa, test
  başarılı sayılır.
- Başarısız kriteri: Herhangi bir test durumu beklenen sonuçla
  sonuçlanmazsa, test başarısız sayılır.
---
Test Durumları (Test Cases)
Test Case 1: Uygulamaya Login Olma
- Test ID:TC001
- Amaç:Uygulamaya Login Olma
- Adımlar:
1. İlgili Url e gidilir.
2. Username bilgisi girilir.
3. Password bilgisi girilir.
4. "Login" butonuna tıklayın.
- Beklenen Sonuç:Uygulamaya Login olunduğu görüntülenmelidir

  Test Case 2: Para Transferi
- Test ID:TC002
- Amaç:Başka bir hesaba para transferi gerçekleştirme.
- Adımlar:
1. İlk login olun.
2. Money Transfer ekranına gidin.
3. "Para Transferi" seçeneğine tıklayın.
4. Gönderen hesap ve alıcı hesabı seçin.
5. Transfer edilecek tutarı girin (örneğin 50 birim).
6. "Send" butonuna tıklayın.
- Beklenen Sonuç:Transfer tamamlandığında her iki hesapta da tutarlar
  güncellenmelidir.

  Test Case 3: Kredi Kartı Zorunlu Alanlar Kontrolü
- Test ID:TC003
- Amaç:Kredi kartı sayfası zorunlu alanların kontrolü
- Adımlar:
1. "Add Money" seçeneğine tıklayın.
2. Kredi kartı bilgilerini girmeden "Onayla" butonuna tıklayın.
3. Zorunlu alanları kontrol edin.
- Beklenen Sonuç:zorunlu alanların doldurulması gerektiği uyarısı
  çıkmalıdır.

  Test Case 4: Kredi Kartı ile Para Ekleme
- Test ID:TC004
- Amaç:Kredi kartı üzerinden hesaba para ekleme.
- Adımlar:
1. "Add Money" seçeneğine tıklayın.
2. Kredi kartı bilgilerini girin.
3. Eklemek istediğiniz tutarı girin.
4. "Onayla" butonuna tıklayın.
- Beklenen Sonuç:Hesap bakiyesi belirtilen tutarla güncellenmelidir.

  Test Case 5: Hesap İsmi Düzenleme
- Test ID:TC005
- Amaç:Hesap ismini değiştirme.
- Adımlar:
1. "Add Money" seçeneğine tıklayın.
2. Account ismini düzenleyin.
3. "Update" butonuna tıklayın.
- Beklenen Sonuç:Hesap ismi başarıyla güncellenmeli ve yeni isimle
  görünmelidir.

  Test Case 6: "0" birim para transferi gerçekleştirme.
- Test ID:TC006
- Amaç:Başka bir hesaba "0" birim para transferi gerçekleştirme.
- Adımlar:
1. İlk login olun.
2. Money Transfer ekranına gidin.
3. "Para Transferi" seçeneğine tıklayın.
4. Gönderen hesap ve alıcı hesabı seçin.
5. Transfer edilecek tutarı girin (örneğin 0 birim).
6. "Send" butonuna tıklayın.
- Beklenen Sonuç:Transfer gerçekleşmemeli ve 0 birimlik para transferi
  yapılamaz uyarısı vermelidir.

  Test Case 7: Kredi Kartı ile "0" birim Para Ekleme
- Test ID:TC007
- Amaç:Kredi kartı üzerinden hesaba "0" birim para ekleme.
- Adımlar:
1. "Add Money" seçeneğine tıklayın.
2. Kredi kartı bilgilerini girin.
3. Eklemek istediğiniz tutarı "0" girin.
4. "Onayla" butonuna tıklayın.
- Beklenen Sonuç:0 birimlik para transferi yapılamaz uyarısı vermelidir.

  Test Case 8: Negatif Bakiye Kontrolü
- Test ID:TC008
- Amaç:Eğer hesap bakiyesi sıfırdan düşük olamaz, bunu doğrulamak.
- Adımlar:
1. Hesap bakiyesini negatif bir değere düşürmeye çalışın.
- Beklenen Sonuç:“Hesap bakiyesi sıfırdan düşük olamaz.” mesajı
  görüntülenmelidir.