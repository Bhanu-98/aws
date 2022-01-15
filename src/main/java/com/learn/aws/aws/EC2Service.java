package com.learn.aws.aws;

import org.springframework.stereotype.Service;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.AttachVolumeRequest;
import com.amazonaws.services.ec2.model.AttachVolumeResult;
import com.amazonaws.services.ec2.model.CreateVolumeRequest;
import com.amazonaws.services.ec2.model.CreateVolumeResult;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.DetachVolumeRequest;
import com.amazonaws.services.ec2.model.DetachVolumeResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import java.util.List;
import java.util.ArrayList;

@Service
public class EC2Service {

    public Object getInstanceDetails() {
        final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();
        boolean done = false;
        List<Instance> instances = new ArrayList<Instance>();
        DescribeInstancesRequest request = new DescribeInstancesRequest();
        while (!done) {
            DescribeInstancesResult response = ec2.describeInstances(request);

            for (Reservation reservation : response.getReservations()) {
                for (Instance instance : reservation.getInstances()) {
                    System.out.printf(
                            "Found instance with id %s, " +
                                    "AMI %s, " +
                                    "type %s, " +
                                    "state %s " +
                                    "and monitoring state %s",
                            instance.getInstanceId(),
                            instance.getImageId(),
                            instance.getInstanceType(),
                            instance.getState().getName(),
                            instance.getMonitoring().getState());
                            instances.add(instance);
                }
            }

            request.setNextToken(response.getNextToken());

            if (response.getNextToken() == null) {
                done = true;
            }
        }
        return instances;
    }

    public Object createVolume(InstanceModel instance){
        final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();
        CreateVolumeRequest createVolumeRequest = new CreateVolumeRequest();
        createVolumeRequest.setAvailabilityZone("us-east-1b");
        createVolumeRequest.setSize(8);
        createVolumeRequest.setVolumeType("gp2");
        // createVolumeRequest.setIops(100);
        CreateVolumeResult response = ec2.createVolume(createVolumeRequest);
        System.out.println(response.getVolume());
        return response;
    }

    public Object attachVolumeToDisk(InstanceModel instance) {
        // AmazonEC2 ec3 = AmazonEC2ClientBuilder.standard().withCredentials(credentialsProvider)
        final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();
        AttachVolumeRequest attachVolumeRequest = new AttachVolumeRequest();
        attachVolumeRequest.setVolumeId(instance.getVolumeId());
        attachVolumeRequest.setInstanceId(instance.getInstanceId());
        attachVolumeRequest.setDevice(instance.getDeviceName());
        AttachVolumeResult response = ec2.attachVolume(attachVolumeRequest);
        return response;
    }

    public Object detachVolumeFromDisk(InstanceModel instance){
        final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();
        DetachVolumeRequest detachVolumeRequest = new DetachVolumeRequest();
        detachVolumeRequest.setVolumeId(instance.getVolumeId());
        detachVolumeRequest.setInstanceId(instance.getInstanceId());
        DetachVolumeResult response = ec2.detachVolume(detachVolumeRequest);
        return response;
    }
}
