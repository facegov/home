package com.facegov.app.web.rest;

import com.facegov.app.web.models.Vendor;
import com.facegov.app.services.VendorService;
import com.facegov.app.web.errors.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorRestController {
  private final VendorService vendorService;

  public VendorRestController(VendorService vendorService) {
    this.vendorService = vendorService;
  }

  @GetMapping
  public List<Vendor> getVendors(){
    return this.vendorService.getVendors();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Vendor addVendor(@RequestBody Vendor model){
    return this.vendorService.createOrUpdateVendor(model);
  }

  @GetMapping("/{id}")
  public Vendor getVendor(@PathVariable("id")long id){
    return this.vendorService.getVendor(id);
  }

  @PutMapping("/{id}")
  public Vendor updateVendor(@PathVariable("id") Long id, @RequestBody Vendor model){
    if (id != model.getVendorId()){
      throw new BadRequestException("incoming id doesn't match path");
    }
    return this.vendorService.createOrUpdateVendor(model);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.RESET_CONTENT)
  public void deleteVendor(@PathVariable("id")long id){
    this.vendorService.deleteVendor(id);
  }
}
