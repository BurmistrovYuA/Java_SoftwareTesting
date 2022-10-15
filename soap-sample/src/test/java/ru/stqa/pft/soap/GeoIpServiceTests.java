package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

  @Test
  public void testMyIp() {

    String geoIp = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("87.117.54.206");
    assertEquals(geoIp, "<GeoIP><Country>RU</Country><State>61</State></GeoIP>");
    System.out.println(geoIp);
  }
  @Test
  public void testInvalidIp() {
    String geoIp = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("87.117.54.xxx");
    assertEquals(geoIp, "<GeoIP><Country>RU</Country><State>61</State></GeoIP>");
    System.out.println(geoIp);
  }
}
