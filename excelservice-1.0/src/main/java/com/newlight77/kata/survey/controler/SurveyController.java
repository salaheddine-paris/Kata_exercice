package com.newlight77.kata.survey.controler;

import com.newlight77.kata.survey.model.Campaign;
import com.newlight77.kata.survey.model.Survey;
import com.newlight77.kata.survey.service.ExportCampaignService;
import org.springframework.web.bind.annotation.*;

@RestController
public class SurveyController {

    private final ExportCampaignService exportCampaignService;

    public SurveyController(final ExportCampaignService exportCampaignService) {
        this.exportCampaignService = exportCampaignService;
    }

    @PostMapping("/api/survey/create")
    public void createSurvey(@RequestBody final Survey survey) {
        exportCampaignService.createSurvey(survey);
    }

    @PutMapping("/api/survey/update")
    public void updateSurvey(@RequestBody final Survey survey) {
        exportCampaignService.updateSurvey(survey);
    }

    @DeleteMapping("/api/survey/delete")
    public void updateSurvey(@PathVariable String id) {
        exportCampaignService.deleteSurvey(id);
    }


    @GetMapping("/api/survey/get")
    public Survey getSurvey(@RequestParam final String id) {
        return exportCampaignService.getSurvey(id);
    }

    @PostMapping("/api/survey/campaign/create")
    public void createCampaign(@RequestBody final Campaign campaign) {
        exportCampaignService.createCampaign(campaign);
    }

    @PutMapping("/api/survey/campaign/update")
    public void updateCampaign(@RequestBody final Campaign campaign) {
        exportCampaignService.updateCampaign(campaign);
    }

    @DeleteMapping("/api/survey/campaign/delete")
    public void deleteCampaign(@PathVariable String id) {
        exportCampaignService.deleteCampaign(id);
    }

    @GetMapping("/api/survey/campaign/get")
    public Campaign getCampaign(@RequestParam final String id) {
        return exportCampaignService.getCampaign(id);
    }

    @PostMapping("/api/survey/campaign/export")
    public void exportCampaign(@RequestParam final String campaignId) {

        final Campaign campaign = exportCampaignService.getCampaign(campaignId);
        final Survey survey = exportCampaignService.getSurvey(campaign.getSurveyId());
        exportCampaignService.sendResults(campaign, survey);

    }
}

