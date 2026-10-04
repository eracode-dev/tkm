# TKM - Taş Kağıt Makas

CoinFlip tarzı bahisli Taş Kağıt Makas oyunu (Bukkit/Paper plugini).

## Özellikler

- `/tkm` GUI menü ile miktar seçip oyun kurma
- `/tkm katıl <oyuncu>` ile bekleyen oyuna katılma
- Tıklanabilir `[TAŞ] [KAĞIT] [MAKAS]` butonları + chat'ten yazarak seçim
- Beraberlikte tekrar tur (veya config ile iade)
- Seçim süresi + süre dolunca hükmen galibiyet/iade
- Vergi kesintisi (`tax-percent`), broadcast duyuruları
- Oyundan ayrılan seçim aşamasındaysa kaybeder, bekleyen oyun iade edilir

## Gereksinimler

- Java 8+
- Spigot/Paper 1.13+ (test edilen: Paper 1.20.1 build 196)
- Vault + bir ekonomi eklentisi (örn. EssentialsX)

## Komutlar

| Komut | Açıklama |
|---|---|
| `/tkm` | Oyun kurma menüsü |
| `/tkm kur <miktar>` | Direkt oyun kur |
| `/tkm katıl <oyuncu>` | Oyuna katıl |
| `/tkm sec <tas/kagit/makas>` | Seçim yap |
| `/tkm iptal` | Oyununu iptal et (sadece bekleyen oyun) |
| `/tkm liste` | Aktif oyunlar |
| `/tkm reload` | Config yenile (`tkm.admin`) |

## Kurulum

1. `Vault.jar` + ekonomi eklentisini `plugins/` klasörüne atın.
2. `TKM-1.0.0.jar` dosyasını `plugins/` klasörüne atın.
3. Sunucuyu başlatın, `plugins/TKM/config.yml` oluşur.

## Derleme

```bash
mvn package
```

Çıktı: `target/TKM-1.0.0.jar`

## Miktar formatı

Türkçe giriş desteklenir: `10.000` → 10000, `10.000,50` → 10000.5, `15000` → 15000.

## Bilinen davranışlar

- Seçim aşamasındayken chat'e `taş/kağıt/makas` (veya `1/2/3`) yazmak seçim sayılır, genel sohbete düşmez.
- `online-mode=false` sunucularda isim sahteciliği mümkündür; production'da `online-mode=true` önerilir.

## Lisans

MIT - detay için `LICENSE` dosyasına bakın.
